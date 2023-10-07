package Controller;

import java.util.ArrayList;

import View.Menu;
import Model.Doctor;
import Repository.DoctorRepository;
import Repository.IDoctorRepository;

public class Program extends Menu<String> {
    private IDoctorRepository doctorRepository;
    static String[] menuChoice = {"Add Doctor", "Update Doctor", "Delete Doctor", "Search Doctor", "Exit"};
    ArrayList<Doctor> doctors;

    public Program(){
        super("========== Doctor Management ==========",menuChoice);
        doctors = new ArrayList<>();
        doctorRepository = new DoctorRepository();
    }

    @Override
    public void execute(int n){
        switch (n){
            case 1:{
                doctorRepository.addDoctor();
                break;
            }
            case 2:{
                doctorRepository.updateDoctor();
                break;
            }
            case 3:{
                doctorRepository.deleteDoctor();
                break;
            }
            case 4:{
                doctorRepository.searchDoctor();
                break;
            }
            case 5:{
                System.exit(0);
            }
        }
    }

}
