package cycling;

public class Rider {

    private String name;
    private int yearOfBirth;
    private int riderId;
    private int teamId;
    private static int count = 0;

    Rider(String name, int yearOfBirth, int teamId) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.teamId = teamId;
        count++;
        riderId = count;

}