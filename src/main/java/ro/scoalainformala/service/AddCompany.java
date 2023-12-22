package ro.scoalainformala.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddCompany {

    public static String service(String name, String website, String country, String description, String founded1, String industry, String employees1) {

        String sres = "";

        try (Connection conn = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/business",
                        "postgres", "lord7777")) {

            int founded = Integer.parseInt(founded1);
            int employees = Integer.parseInt(employees1);

            //String st = "INSERT INTO firms(\"name\", \"website\", \"country\", \"description\", \"founded\", \"industry\", \"employees\") " + "values ('" + name + "', '" + website + "', '" + country + "', '" + description + "', " + founded + ", '" + industry + "', " + employees + ")";
            String st = "INSERT INTO firms(name, website, country, description, founded, industry, employees) " + "values ('" + name + "', '" + website + "', '" + country + "', '" + description + "', " + founded + ", '" + industry + "', " + employees + ")";
            try {
                PreparedStatement ps = conn.prepareStatement(st);
                ps.executeQuery();
            } catch (Exception e) {
                //System.err.println("SQL sintax error.");
            }

            String htmlCopmpany = "<div class='wcompanycl'>" +
                    "<div class='wnamecl'><div class='namecl'>" + name + "</div></div>" +
                    "<div class='winfocl'>" +
                    "<div class='industrycl'>Industry: " + industry + "</div>" +
                    "<div class='descriptioncl'>Description: " + description + "</div>" +
                    "<div class='employeescl'>Employees: " + employees + "</div>" +
                    "<div class='foundedcl'>Founded: " + founded + "</div>" +
                    "</div>" +
                    "<div class='wlocationcl'>" +
                    "<div class='countrycl'>" + country + "</div>" +
                    "<div class='wwebsitecl'><a class='websitecl' href='" + website + "'>" + website + "</a></div>" +
                    "</div>" +
                    "</div>";
            sres = "<h2 style='margin: 50px;'>Congratulation! Your business was added to the database.</h2>" + htmlCopmpany;
        } catch (SQLException e) {
            sres = "<h2 style='margin: 50px;color: darkred;'>Database offline! Please try again later.</h2>";
        }

        return sres;
    }

}
