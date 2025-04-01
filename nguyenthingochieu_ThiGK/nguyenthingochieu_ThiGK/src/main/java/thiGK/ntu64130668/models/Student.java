package thiGK.ntu64130668.models;

public class Student {
    private String id;
    private String name;
    private String groupId;

    // Constructor
    public Student(String id, String name, String groupId) {
        this.id = id;
        this.name = name;
        this.groupId = groupId;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
