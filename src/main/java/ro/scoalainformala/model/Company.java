package ro.scoalainformala.model;

public class Company {
    private String name;
    private String website;
    private String country;
    private String description;
    private String founded;
    private String industry;
    private String employees;

    public Company() {
    }

    public Company(String name, String website, String country, String description, String founded, String industry, String employees) {
        this.name = name;
        this.website = website;
        this.country = country;
        this.description = description;
        this.founded = founded;
        this.industry = industry;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public String getWebsite() {
        return website;
    }

    public String getCountry() {
        return country;
    }

    public String getDescription() {
        return description;
    }

    public String getFounded() {
        return founded;
    }

    public String getIndustry() {
        return industry;
    }

    public String getEmployees() {
        return employees;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setEmployees(String employees) {
        this.employees = employees;
    }

}
