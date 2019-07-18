package sample;

public class ModelTable {
    Integer patientIDs,ages,CancerLevel;
    long phoneNos;
    String names,dobs,emails,extraDetails;

    public ModelTable(Integer patientIDs, String names,Integer ages,  String dobs, String emails,long phoneNos, String extraDetails, Integer CancerLevel ) {
        this.patientIDs = patientIDs;
        this.ages = ages;
        this.CancerLevel = CancerLevel;
        this.phoneNos = phoneNos;
        this.names = names;
        this.dobs = dobs;
        this.emails = emails;
        this.extraDetails = extraDetails;
    }

    public Integer getPatientIDs() {
        return patientIDs;
    }

    public void setPatientIDs(Integer patientIDs) {
        this.patientIDs = patientIDs;
    }

    public Integer getAges() {
        return ages;
    }

    public void setAges(Integer ages) {
        this.ages = ages;
    }

    public Integer getCancerLevel() {
        return CancerLevel;
    }

    public void setCancerLevel(Integer cancerLevel) {
       this.CancerLevel = cancerLevel;
    }

    public long getPhoneNos() {
        return phoneNos;
    }

    public void setPhoneNos(long phoneNos) {
        this.phoneNos = phoneNos;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getDobs() {
        return dobs;
    }

    public void setDobs(String dobs) {
        this.dobs = dobs;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getExtraDetails() {
        return extraDetails;
    }

    public void setExtraDetails(String extraDetails) {
        this.extraDetails = extraDetails;
    }
}
