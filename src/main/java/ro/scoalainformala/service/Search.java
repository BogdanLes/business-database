package ro.scoalainformala.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Search {

    public static String service(String w) {

        String searchWord = w;
        String[] asearchWord = searchWord.split(" ");
        List<String> serverResponseList = new ArrayList<>();

        // prepare sql querry and database search
        String st = "";
        //String sqlsh = "(LOWER(name) LIKE LOWER('%" + searchWord + "%') OR LOWER(country) LIKE LOWER('%" + searchWord + "%') OR LOWER(description) LIKE LOWER('%" + searchWord + "%') OR LOWER(industry) LIKE LOWER('%" + searchWord + "%'))";
        String sqlsh = "";
        for (int i = 0; i < asearchWord.length; i++) {
            if (i == 0) {
                sqlsh = "(LOWER(name) LIKE LOWER('%" + asearchWord[i] + "%') OR LOWER(country) LIKE LOWER('%" + asearchWord[i] + "%') OR LOWER(description) LIKE LOWER('%" + asearchWord[i] + "%') OR LOWER(industry) LIKE LOWER('%" + asearchWord[i] + "%'))";
            } else {
                sqlsh = sqlsh + "AND (LOWER(name) LIKE LOWER('%" + asearchWord[i] + "%') OR LOWER(country) LIKE LOWER('%" + asearchWord[i] + "%') OR LOWER(description) LIKE LOWER('%" + asearchWord[i] + "%') OR LOWER(industry) LIKE LOWER('%" + asearchWord[i] + "%'))";
            }
        }

        st = "SELECT * FROM firms WHERE " + sqlsh + ";";
        try (Connection conn = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/business",
                        "postgres", "lord7777")) {

            try {
                PreparedStatement ps = conn.prepareStatement(st);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("name");
                    String website = rs.getString("website");
                    String country = rs.getString("country");
                    String description = rs.getString("description");
                    String founded = rs.getString("founded");
                    String industry = rs.getString("industry");
                    String employees = rs.getString("employees");

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
                    serverResponseList.add(htmlCopmpany);

                }
            } catch (Exception e) {
                System.err.println("SQL query error.");
            }

        } catch (SQLException e) {
            System.err.println("Could not get connection.");
        }

        //prepare server response
        String serverResponse = "";
        int result = serverResponseList.size();
        serverResponse = "<div class='wwresultscl'><div class='wresultscl'><div class='resultscl'>Results: " + result + "</div></div></div>";
        for (int i = 0; i < serverResponseList.size(); i++) {
            serverResponse = serverResponse + serverResponseList.get(i).toString();
        }
        serverResponse = "<div class='allserverres'>" + serverResponse + "</div>";

        return serverResponse;
    }

}
