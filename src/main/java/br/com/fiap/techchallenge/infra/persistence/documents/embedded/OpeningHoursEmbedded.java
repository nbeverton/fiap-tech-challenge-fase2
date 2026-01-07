package br.com.fiap.techchallenge.infra.persistence.documents.embedded;

public class OpeningHoursEmbedded {
    private String opens;
    private String closes;

    public OpeningHoursEmbedded() {}

    public OpeningHoursEmbedded(String opens, String closes) {
        this.opens = opens;
        this.closes = closes;
    }

    public String getOpens() {
        return opens;
    }

    public void setOpens(String opens) {
        this.opens = opens;
    }

    public String getCloses() {
        return closes;
    }

    public void setCloses(String closes) {
        this.closes = closes;
    }
}
