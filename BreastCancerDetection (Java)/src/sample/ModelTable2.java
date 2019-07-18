package sample;

public class ModelTable2 {
    Integer patientIDs;
    String names;
    Integer ages;
    String extraDetailS;
    Integer cancerLevels;

    public ModelTable2(Integer patientIDs, String names, Integer ages, String extraDetailS, Integer cancerLevels) {
        this.patientIDs = patientIDs;
        this.names = names;
        this.ages = ages;
        this.extraDetailS = extraDetailS;
        this.cancerLevels = cancerLevels;
    }

    public Integer getPatientIDs() {
        return patientIDs;
    }

    public void setPatientIDs(Integer patientIDs) {
        this.patientIDs = patientIDs;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Integer getAges() {
        return ages;
    }

    public void setAges(Integer ages) {
        this.ages = ages;
    }

    public String getExtraDetailS() {
        return extraDetailS;
    }

    public void setExtraDetailS(String extraDetailS) {
        this.extraDetailS = extraDetailS;
    }

    public Integer getCancerLevels() {
        return cancerLevels;
    }

    public void setCancerLevels(Integer cancerLevels) {
        this.cancerLevels = cancerLevels;
    }
}
