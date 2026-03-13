package Hospital_Management_System;
import java.util.*;
public class DiseaseService {
    private List<Disease> list = new ArrayList<>();
    public void addRecord(Disease d) {
        list.add(d);
    }
    public List<Disease> getAll() {
        return list;
    }
    public List<Disease> getByPatient(String cnic) {
        List<Disease> result = new ArrayList<>();
        for(Disease d : list) {
            if(d.getPatientCnic().equals(cnic))
                result.add(d);
        }
        return result;
    }
}
