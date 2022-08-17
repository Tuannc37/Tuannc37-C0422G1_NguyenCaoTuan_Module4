package com.repository.impl;

import com.model.Declaration;
import com.repository.IDeclarationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DeclarationRepositoryImpl implements IDeclarationRepository {
    private static List<Declaration> declarations = new ArrayList<>();
    static {

        declarations.add(new Declaration(1 ,"Tuấn", "1997", "Male", "Viet Nam",
                "3232431", "Tàu bay", "31341", 2, "09", "09","2014", "09", "09","2018",
                "da nang"));
        declarations.add(new Declaration(2 ,"Huy", "1997", "Male", "Viet Nam",
                "3232431", "Tàu bay", "31341", 2, "09", "09","2014", "09", "09","2018",
                "da nang"));
        declarations.add(new Declaration(3 ,"Vinh", "1997", "Male", "Viet Nam",
                "3232431", "Tàu bay", "31341", 2, "09", "09","2014", "09", "09","2018",
                "da nang"));
    }

    @Override
    public List<Declaration> findAll() {
        return declarations;
    }

    @Override
    public List<String> gender() {
        List<String> listGender = new ArrayList<>();
        listGender.add("Male");
        listGender.add("Female");
        return listGender;
    }

    @Override
    public List<String> nationality() {
        List<String> listNationality = new ArrayList<>();
        listNationality.add("Việt Nam");
        listNationality.add("Lào");
        listNationality.add("Campuchia");
        listNationality.add("Trung Quốc");
        return listNationality;
    }

    @Override
    public List<Integer> day() {
        List<Integer> listDay = new ArrayList<>();
        for (int i = 1;i <= 31;i++){
            listDay.add(i);
        }
        return listDay;
    }

    @Override
    public List<Integer> month() {
        List<Integer> listMonth = new ArrayList<>();
        for (int i = 1;i <= 12;i++){
            listMonth.add(i);
        }
        return listMonth;
    }

    @Override
    public List<Integer> year() {
        List<Integer> listYear = new ArrayList<>();
        for (int i = 1980;i <= 2022;i++){
            listYear.add(i);
        }
        return listYear;
    }

    @Override
    public Declaration findById(int id) {
        for (Declaration item: declarations) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void create(Declaration declaration) {
        declarations.add(declaration);
    }

    @Override
    public void update(int id, Declaration declaration) {
        for (Declaration item: declarations) {
            if (item.getId() == id) {
                item.setName(declaration.getName());
                item.setBirthDay(declaration.getBirthDay());
                item.setGenDer(declaration.getGenDer());
                item.setNationality(declaration.getNationality());
                item.setNationality(declaration.getNationality());
                item.setPassportId(declaration.getPassportId());
                item.setTravelInformation(declaration.getTravelInformation());
                item.setSeats(declaration.getSeats());
                item.setStartDay(declaration.getStartDay());
                item.setStartMonth(declaration.getStartMonth());
                item.setStartYear(declaration.getStartYear());
                item.setEndDay(declaration.getEndDay());
                item.setEndMonth(declaration.getEndMonth());
                item.setEndYear(declaration.getEndYear());
                item.setTravelHistory(declaration.getTravelHistory());
            }
        }
    }
}
