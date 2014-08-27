/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoinsert;

import entities.PackageInfo;
import entities.PackageTours;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import untils.HibernateUtil;

/**
 *
 * @author Tien
 */
public class AutoInsert {

    Document doc;

    Session sf;

    public AutoInsert() {
        sf = HibernateUtil.getSessionFactory().openSession();
    }

    public static void main(String[] args) {
       
              new AutoInsert().readItem("https://www.triip.me/indonesia/bandung/");
//            AutoInsert.saveImage("https://lh6.ggpht.com/7UYHJhCqYwSSiB5FbvJCAlBJ-wcAJB2k1MBjxyuXfsYTEFJBAPUPph16MiIqnwfKmWlYKZfE_CeDNXnZBDih7rWOzg=s342");
       
    }

    public void readItem(String url) {
        try {
            doc = Jsoup.connect(url).timeout(10 * 1000).get();
            Elements newsHeadlines = doc.select("#triip_list_wr .jcarousel li");
            for (Element link : newsHeadlines) {
                String title = link.select(".tb_title").text();
                String image = link.select(".tb_img[style]").first().attr("style").split("url")[1].replaceAll("\\)", "").replaceAll("\\(", "");
                String price = link.select(".price").text().replaceAll("\\$", "");
                String description = link.select(".tb_desc p").text();
                String place = link.select(".tb_place").text();
                System.out.println("text : " + title);
                System.out.println("image : " + image);
                System.out.println("price:" + price);
                System.out.println("description:" + description);
                System.out.println("place:" + place);
                System.out.println("url:" + link.select("a").attr("href"));
            
                PackageTours pt = new PackageTours();
                pt.setTouristName(title);
                pt.setImagesTouris(saveImage(image));
                pt.setTourisDuration("");
                pt.setTouristDescription(description);
                pt.setTourisPrice(Integer.parseInt(price));
                pt.setTouristPlace("Indonesia");
                pt.setCityCountry(place);
                pt.setTypePackage("CWT");
                insertPT(pt);
                PackageInfo info = new PackageInfo();
                info.setPackageTours(getID(title));
                info.setContent(readInfo("https://www.triip.me" + link.select("a").attr("href")));
                insertIF(info);
                System.out.println("-------------------------------------------------------");

            }
        } catch (IOException ex) {
            Logger.getLogger(AutoInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String saveImage(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        String fileName = url.getFile();
        String destName = "C:\\Users\\Tien\\Desktop\\Project-G4\\Source\\East2WestTours\\web\\images" + fileName.substring(fileName.lastIndexOf("/"))+".jpg";
        System.out.println(destName);

        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destName);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
        return "images"+fileName.substring(fileName.lastIndexOf("/"))+".jpg";
    }

    public String readInfo(String url) {
        Elements newsHeadlines = null;
        try {
            doc = Jsoup.connect(url).timeout(10 * 1000).get();
            newsHeadlines = doc.select("#triip_highlights");
            System.out.println(newsHeadlines);
        } catch (IOException ex) {
            Logger.getLogger(AutoInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newsHeadlines.outerHtml();
    }

    public void insertPT(PackageTours pt) {
        try {
            sf.beginTransaction();
            sf.save(pt);
            sf.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void insertIF(PackageInfo info) {
        sf.beginTransaction();
        sf.save(info);
        sf.getTransaction().commit();
    }

    public int getID(String name) {
        Criteria criteria = sf.createCriteria(PackageTours.class)
                .add(Restrictions.eq("touristName", name));

        Object result = criteria.uniqueResult();
        PackageTours genre = null;
        if (result != null) {
            genre = (PackageTours) result;
            System.out.println("IDD = " + genre.getTouristId());
        }
        return genre.getTouristId();
    }

}
