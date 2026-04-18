package com.example.CT5209_CA_LL.Controllers;

import com.example.CT5209_CA_LL.Domain.Petition;
import com.example.CT5209_CA_LL.Domain.Signature;
import com.example.CT5209_CA_LL.Services.PetitionService;
import com.example.CT5209_CA_LL.Services.SignatureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PetitionController {

    private final PetitionService petitionService;
    private final SignatureService signatureService;

    // Allows us to use methods from our signatures and petitions service inside the controller
    public PetitionController(PetitionService petitionService, SignatureService signatureService) {
        this.petitionService = petitionService;
        this.signatureService = signatureService;
    }

    // Will display all the petitions
    @GetMapping("/showAll")
    public String listPetitions(Model model) {
        model.addAttribute("petitions", petitionService.getAllPetitions());
        return "showAll";
    }

    // Displays the page for creating petitions
    @GetMapping("/create")
    public String showCreateForm() {
        return "create";
    }

    // POSTs the petition to our ArrayList and stores it
    @PostMapping("/create")
    public String createPetition(@RequestParam String title, @RequestParam String description) {
        petitionService.createPetition(title, description);
        // Returns us to the home page
        return "redirect:/";
    }

    // Shows the search page
    @GetMapping("/search")
    public String showSearchPage() {
        return "search";
    }

    // POSTs the search method to our petitions service and returns results based on the term
    @PostMapping("/search")
    public String searchResults(@RequestParam String keyword, Model model) {
        model.addAttribute("results", petitionService.search(keyword));
        return "searchResults";
    }

    // Displays the petition the user clicks on
    @GetMapping("/petition/{id}")
    public String viewPetition(@PathVariable int id, Model model) {
        Petition petition = petitionService.getPetitionById(id);
        model.addAttribute("petition", petition);
        return "view";
    }

    // User can sign the petition and their signature is added to the petition list
    @PostMapping("/petition/{id}/sign")
    public String signPetition(@PathVariable int id, @RequestParam String name, @RequestParam String email) {
        Signature signature = signatureService.createSignature(name, email);
        petitionService.signPetition(id, signature);
        return "redirect:/petition/" + id;
    }
}
