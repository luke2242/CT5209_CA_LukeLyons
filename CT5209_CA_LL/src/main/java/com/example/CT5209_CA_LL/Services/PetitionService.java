package com.example.CT5209_CA_LL.Services;

import com.example.CT5209_CA_LL.Domain.Petition;
import com.example.CT5209_CA_LL.Domain.Signature;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetitionService {

    // This list will store our petitions
    private final List<Petition> petitions = new ArrayList<>();

    // ID counter
    private int nextId = 1;

    public PetitionService() {
        // sample data
        petitions.add(new Petition(nextId++, "HelloWorld js", "The next big Javascript framework!", new ArrayList<>()));
        petitions.add(new Petition(nextId++, "Linux95", "Reviving the classic feel of Windows 95!", new ArrayList<>()));
    }

    // Returns all petitions
    public List<Petition> getAllPetitions() {
        return petitions;
    }

    // Returns a specific petition
    public Petition getPetitionById(int id) {

        // We increments through the list until we find the matching id
        for (Petition p : petitions) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // Creates petition and adds it to our arraylist
    public Petition createPetition(String title, String description) {
        Petition petition = new Petition(nextId++, title, description, new ArrayList<>());
        petitions.add(petition);
        return petition;
    }


    public List<Petition> search(String keyword) {
        // Stores the results of the inputted search term
        List<Petition> results = new ArrayList<>();
        // puts the search term to lowercase
        String lower = keyword.toLowerCase();

        // Goes through the petitions arraylist until we find matching string
        for (Petition p : petitions) {
            if (p.getTitle().toLowerCase().contains(lower)) {
                results.add(p);
            }
        }
        return results;
    }

    // Will allow user to sign the petition
    public void signPetition(int id, Signature signature) {

        // gets the petition
        Petition petition = getPetitionById(id);
        if (petition != null) {
            petition.getSignatures().add(signature);
        }
    }
}

