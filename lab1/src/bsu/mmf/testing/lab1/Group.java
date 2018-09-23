package bsu.mmf.testing.lab1;

import java.util.ArrayList;

public class Group {
    private int groupId;
    private ArrayList<Student> students;

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("");
        res.append("Группа: " + groupId + "\n");
        for (int i = 0; i < getStudents().size(); i++) {
            res.append(getStudents().get(i).toString());
        }
        return res.toString();
    }

    public Group(int groupId, ArrayList<Student> students) {
        this.groupId = groupId;
        this.students = students;
    }

    public int getGroupId() {
        return groupId;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public double getAverageRatingOfGroup() {
        double avg = 0;
        int length = 0;
        for (int i = 0; i < getStudents().size(); i++) {
            for (int j = 0; j < getStudents().get(i).getRating().length; j++) {
                avg += getStudents().get(i).getRating()[j];
                length++;
            }
        }
        avg /= length;
        return avg;
    }
}
