package com.example.bestioles;

import com.example.bestioles.model.Animal;
import com.example.bestioles.repository.AnimalRepository;
import com.example.bestioles.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class BestiolesApplication implements CommandLineRunner {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private SpeciesRepository speciesRepository;

    public static void main(String[] args) {
        SpringApplication.run(BestiolesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("\n========== 1. findAll() – liste de tous les animaux ==========");
        List<Animal> tous = animalRepository.findAll();
        tous.forEach(a -> System.out.println(
                "[" + a.getId() + "] " + a.getName() + " (" + a.getSex() + ") – "
                + a.getSpecies().getCommonName() + " – couleur : " + a.getColor()
        ));

        System.out.println("\n========== 2. save() – ajout d'un nouvel animal ==========");
        Animal newAnimal = new Animal();
        newAnimal.setName("Gaston");
        newAnimal.setSex("M");
        newAnimal.setColor("Tigré");
        // On réutilise l'espèce "Chat" (id=1) déjà en BDD
        speciesRepository.findById(1).ifPresent(newAnimal::setSpecies);
        Animal saved = animalRepository.save(newAnimal);
        System.out.println("Nouvel animal sauvegardé : [" + saved.getId() + "] " + saved.getName());

        System.out.println("\n========== 3. findById() – recherche par id ==========");
        Optional<Animal> found = animalRepository.findById(1);
        found.ifPresentOrElse(
                a -> System.out.println("Trouvé : " + a.getName() + " – " + a.getSpecies().getCommonName()),
                () -> System.out.println("Animal non trouvé")
        );

        System.out.println("\n========== 4. delete() – suppression puis vérification ==========");
        System.out.println("Nombre d'animaux avant suppression : " + animalRepository.count());
        animalRepository.delete(saved); // on supprime celui qu'on vient de créer
        System.out.println("Nombre d'animaux après suppression  : " + animalRepository.count());

        System.out.println("\n========== Fin des tests ==========");
    }
}
