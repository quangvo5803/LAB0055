package DataAccess;

import java.util.ArrayList;

import Common.Validation;
import Model.Doctor;

public class DoctorDao {
    private static DoctorDao instance = null;

    public static DoctorDao Instance() {
        if (instance == null) {
            synchronized (DoctorDao.class) {
                if (instance == null) {
                    instance = new DoctorDao();
                }
            }
        }
        return instance;
    }

    public Doctor getDoctorById(ArrayList<Doctor> doctors) {
        String code = Validation.getString("Enter doctor ID: ");
        for (Doctor d : doctors) {
            if (d.getCode().equalsIgnoreCase(code)) {
                return d;
            }
        }
        return null;
    }

    public void addDoctor(ArrayList<Doctor> doctors) {
        while (true) {
            System.out.println();
            System.out.println("========== ADD DOCTOR ==========");
            String code = "DOC" + String.valueOf(doctors.size() + 1);
            String name = Validation.getString("Enter doctor name: ");
            String specialization = Validation.getString("Enter doctor specialization: ");
            int availability = Validation.getInt("Enter doctor availability: ");
            doctors.add(new Doctor(code, name, specialization, availability));
            System.out.println("Add successful");
            System.out.println();
            if(Validation.getYesNo("Do you want to continue(Y/N): ").equalsIgnoreCase("N")){
                return;
            }
        }
    }

    public void updateDoctor(ArrayList<Doctor> doctors) {
        System.out.println();
        System.out.println("========== UPDATE DOCTOR ==========");
        Doctor d = getDoctorById(doctors);
        if (d == null) {
            System.out.println("Doctor code does not exist");
            System.out.println();
            return;
        } else {
            String name = Validation.getString("Enter update doctor name: ");
            String specialization = Validation.getString("Enter update doctor specialization: ");
            int availability = Validation.getInt("Enter update doctor availability: ");
            if (name != null) {
                d.setName(name);
            }
            if (specialization != null) {
                d.setSpecialization(specialization);
            }
            d.setAvailability(availability);
            System.out.println("Update successful");
            System.out.println();
        }
    }

    public void deleteDoctor(ArrayList<Doctor> doctors) {
        System.out.println();
        System.out.println("========== DELETE DOCTOR ==========");
        Doctor d = getDoctorById(doctors);
        if (d == null) {
            System.out.println("Doctor code does not exist");
            System.out.println();
            return;
        } else {
            doctors.remove(d);
            System.out.println("Delete successful");
            System.out.println();
        }
    }

    public void searchDoctor(ArrayList<Doctor> doctors) {
        System.out.println();
        System.out.println("========== SEARCH DOCTOR ==========");
        if (doctors.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        String searchInformation = Validation.getString("Enter search information(Name,Specialization,Availability): ");
        while (searchInformation.isEmpty()) {
            System.out.println("Can not blank");
            searchInformation = Validation.getString("Enter again: ");
        }
        ArrayList<Doctor> searchList = new ArrayList<>();
        for (Doctor d : doctors) {
            if (d.getName().contains(searchInformation) || d.getSpecialization().contains(searchInformation)
                    || d.getAvailability() == Integer.parseInt(searchInformation)) {
                searchList.add(d);
            }
        }
        if (searchList.isEmpty()) {
            System.out.println("Can not found");
            System.out.println();
        } else {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
            for (Doctor doctor : searchList) {
                System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(),
                        doctor.getName(), doctor.getSpecialization(),
                        doctor.getAvailability());
            }

        }
    }
}
