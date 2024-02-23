public class MaritimeAttack {
    private String date;
    private String time;
    private double longitude;
    private double latitude;
    private String attackType;
    private String locationDescription;
    private String nearestCountry;
    private String eezCountry;
    private double shoreDistance;
    private double shoreLongitude;
    private double shoreLatitude;
    private String attackDescription;
    private String vesselName;
    private String vesselType;
    private String vesselStatus;
    private String dataSource;

    public MaritimeAttack(String date, String time, double longitude, double latitude, String attackType,
            String locationDescription, String nearestCountry, String eezCountry, double shoreDistance,
            double shoreLongitude, double shoreLatitude, String attackDescription, String vesselName, String vesselType,
            String vesselStatus, String dataSource) {
        this.date = date;
        this.time = time;
        this.longitude = longitude;
        this.latitude = latitude;
        this.attackType = attackType;
        this.locationDescription = locationDescription;
        this.nearestCountry = nearestCountry;
        this.eezCountry = eezCountry;
        this.shoreDistance = shoreDistance;
        this.shoreLongitude = shoreLongitude;
        this.shoreLatitude = shoreLatitude;
        this.attackDescription = attackDescription;
        this.vesselName = vesselName;
        this.vesselType = vesselType;
        this.vesselStatus = vesselStatus;
        this.dataSource = dataSource;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getAttackType() {
        return attackType;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public String getNearestCountry() {
        return nearestCountry;
    }

    public String getEezCountry() {
        return eezCountry;
    }

    public double getShoreDistance() {
        return shoreDistance;
    }

    public double getShoreLongitude() {
        return shoreLongitude;
    }

    public double getShoreLatitude() {
        return shoreLatitude;
    }

    public String getAttackDescription() {
        return attackDescription;
    }

    public String getVesselName() {
        return vesselName;
    }

    public String getVesselType() {
        return vesselType;
    }

    public String getVesselStatus() {
        return vesselStatus;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setAttackType(String attackType) {
        this.attackType = attackType;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public void setNearestCountry(String nearestCountry) {
        this.nearestCountry = nearestCountry;
    }

    public void setEezCountry(String eezCountry) {
        this.eezCountry = eezCountry;
    }

    public void setShoreDistance(double shoreDistance) {
        this.shoreDistance = shoreDistance;
    }

    public void setShoreLongitude(double shoreLongitude) {
        this.shoreLongitude = shoreLongitude;
    }

    public void setShoreLatitude(double shoreLatitude) {
        this.shoreLatitude = shoreLatitude;
    }

    public void setAttackDescription(String attackDescription) {
        this.attackDescription = attackDescription;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public void setVesselType(String vesselType) {
        this.vesselType = vesselType;
    }

    public void setVesselStatus(String vesselStatus) {
        this.vesselStatus = vesselStatus;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String toString() {
        return "MaritimeAttack [date=" + date + ", time=" + time + ", longitude=" + longitude + ", latitude=" + latitude
                + ", attackType=" + attackType + ", locationDescription=" + locationDescription + ", nearestCountry="
                + nearestCountry + ", eezCountry=" + eezCountry + ", shoreDistance=" + shoreDistance
                + ", shoreLongitude="
                + shoreLongitude + ", shoreLatitude=" + shoreLatitude + ", attackDescription=" + attackDescription
                + ", vesselName=" + vesselName + ", vesselType=" + vesselType + ", vesselStatus=" + vesselStatus
                + ", dataSource=" + dataSource + "]";
    }
}
