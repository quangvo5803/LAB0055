package Repository;

import java.util.ArrayList;

import Common.Validation;
import DataAccess.DoctorDao;
import Model.Doctor;

public class DoctorRepository implements IDoctorRepository{
    private ArrayList<Doctor> doctors;


    public DoctorRepository() {
        doctors = new ArrayList<>();
    }

    public void getDoctorById(){
        DoctorDao.Instance().getDoctorById(doctors);
    }

    public void addDoctor(){
        DoctorDao.Instance().addDoctor(doctors);
    }

    public void updateDoctor(){
        DoctorDao.Instance().updateDoctor(doctors);
    }

    public void deleteDoctor(){
        DoctorDao.Instance().deleteDoctor(doctors);
    }

    public void searchDoctor(){
        DoctorDao.Instance().searchDoctor(doctors);
    }
}
