package com.mehdirefactoring.com.thisisrefactoring.model;
// Refused Bequest code smell
public class SponsoredPost extends BlogPost {
    private String sponsorName;
    private double sponsorshipAmount;

    public SponsoredPost(String title, String content, String sponsorName, double sponsorshipAmount) {
        super(title, content, null); // "Author" is irrelevant here
        this.sponsorName = sponsorName;
        this.sponsorshipAmount = sponsorshipAmount;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public double getSponsorshipAmount() {
        return sponsorshipAmount;
    }

    public void setSponsorshipAmount(double sponsorshipAmount) {
        this.sponsorshipAmount = sponsorshipAmount;
    }

    @Override
    public void displayPostDetails() {
        System.out.println("Title: " + getTitle());
        System.out.println("Content: " + getContent());
        System.out.println("Sponsor: " + sponsorName);
        System.out.println("Sponsorship Amount: " + sponsorshipAmount);
    }
}
