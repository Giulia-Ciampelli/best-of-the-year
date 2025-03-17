// Step 1
// Creare un nuovo progetto Spring Boot MVC + Thymeleaf (puoi trovare il processo sia nella lezione che nelle slide). Il nome del progetto è best-of-the-year (stesso nome della repository).

// Nel progetto aggiungere un controller che risponde alla root dell’applicazione, con un metodo che restituisce una view fatta con Thymeleaf in cui viene stampato un titolo: “Best of the year by …” (al posto dei puntini deve apparire il vostro nome, passato come attributo dal controller attraverso il Model).

// Step 2
// Creare all’interno del controller due metodi privati :
// uno restituisce una lista di oggetti di tipo Movie - getBestMovies()
// l’altro restituisce una lista di oggetti di tipo Song - getBestSongs()

// Creare le classi Movie e Song aventi almeno :
// un id
// un titolo

// Aggiungere al controller altri due metodi, che rispondono agli url
// “/movies”
// “/songs”

// In ognuno di questi metodi aggiungere al Model un attributo stringa con una lista di titoli di migliori film o canzoni (in base al metodo che stiamo implementando) separati da virgole. Utilizzare i due metodi getBest… per recuperare i film e le canzoni.

// Creare i rispettivi template Thymeleaf.

// Step 3
// Creare due metodi
// “/movies/{id}”
// “/songs/{id}” che dato il parametro id passato tramite il path, mostri in pagina il titolo relativo al film / canzone.

// Testare chiamando dal browser i diversi url.
// Step 4
// Includere Bootstrap e fare il refactoring del layout come da allegato, cercando di creare componenti riutilizzabili con i fragments.

// Modificare i metodi che rispondono agli url
// “/movies”
// “/songs”
// In modo che entrambi i Model restituiscano una lista di oggetti (Movie o Song) invece di una stringa. 

// Modificare anche le rispettive view.
// Step 5 : Bonus
// Ogni elemento mostrato nella lista (film o canzone) deve essere un link che punta alla rispettiva pagina di dettaglio (e anche in questo caso restituire il Model al posto della stringa col titolo).

// Nella pagina home (quella che risponde alla root dell’applicazione) aggiungere due link che portano agli url /movies e /songs.

// Nelle pagine con le liste aggiungere un link che riporta alla home page.

// Testare navigando l’applicazione.

package org.lessons.java.best.best_of_the_year.controllers;

import java.util.ArrayList;

import org.lessons.java.best.best_of_the_year.classes.Movie;
import org.lessons.java.best.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class Homecontroller {

    @GetMapping("/")
    public String home(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }

    // #region metodi
    private ArrayList<Movie> getBestMovies() {
        Movie movie1 = new Movie(1, "Inside Out 2", 98,
                "Sequel del celebre film d'animazione che esplora le emozioni di una giovane ragazza.");
        Movie movie2 = new Movie(2, "Wonka", 116, "Storia delle origini del celebre cioccolatiere Willy Wonka.");
        Movie movie3 = new Movie(3, "Kung Fu Panda 4", 94,
                "Nuove avventure del panda Po mentre affronta sfide eroiche.");
        Movie movie4 = new Movie(4, "Dogman", 53, "Film drammatico diretto da Luc Besson.");
        Movie movie5 = new Movie(5, "The Creator", 55, "Film d'azione diretto da Gareth Edwards.");
        Movie movie6 = new Movie(6, "Adagio", 57, "Film drammatico diretto da Stefano Sollima.");
        Movie movie7 = new Movie(7, "The Old Oak", 113, "Film drammatico diretto da Ken Loach.");
        Movie movie8 = new Movie(8, "Taylor Swift - The Eras Tour", 170,
                "Film musicale diretto da Sam Wrench, che documenta il tour di Taylor Swift.");
        Movie movie9 = new Movie(9, "Blue Beetle", 127, "Film di fantascienza diretto da Angel Manuel Soto.");
        Movie movie10 = new Movie(10, "Wonder - White Bird", 120, "Film biografico diretto da Marc Forster.");

        ArrayList<Movie> listaFilm = new ArrayList<>();
        listaFilm.add(movie1);
        listaFilm.add(movie2);
        listaFilm.add(movie3);
        listaFilm.add(movie4);
        listaFilm.add(movie5);
        listaFilm.add(movie6);
        listaFilm.add(movie7);
        listaFilm.add(movie8);
        listaFilm.add(movie9);
        listaFilm.add(movie10);

        return listaFilm;
    }

    private ArrayList<Song> getBestSongs() {
        Song song1 = new Song(1, "Genesis", "Raye", "My 21st Century Blues");
        Song song2 = new Song(2, "Happy Mistake", "Lady Gaga", "Harlequin");
        Song song3 = new Song(3, "Friend of a Friend", "The Smile", "Bending the Arc");
        Song song4 = new Song(4, "Balloon", "Tyler, The Creator feat. Doechii", "Call Me If You Get Lost");
        Song song5 = new Song(5, "Good Luck, Babe!", "Chappell Roan", "The Rise and Fall of a Midwest Princess");
        Song song6 = new Song(6, "Starburster", "Fontaines D.C.", "Skinty Fia");
        Song song7 = new Song(7, "Roy", "Idles", "CRAWLER");
        Song song8 = new Song(8, "Not Like Us", "Kendrick Lamar", "Mr. Morale & The Big Steppers");
        Song song9 = new Song(9, "Beautiful Things", "Benson Boone", "Walk Me Home");
        Song song10 = new Song(10, "Expresso", "Sabrina Carpenter", "Emails I Can't Send");

        ArrayList<Song> listaCanzoni = new ArrayList<>();
        listaCanzoni.add(song1);
        listaCanzoni.add(song2);
        listaCanzoni.add(song3);
        listaCanzoni.add(song4);
        listaCanzoni.add(song5);
        listaCanzoni.add(song6);
        listaCanzoni.add(song7);
        listaCanzoni.add(song8);
        listaCanzoni.add(song9);
        listaCanzoni.add(song10);

        return listaCanzoni;
    }

    // #endregion metodi

    // pagina lista film
    @GetMapping("/movies")
    public String movies(Model model) {
        ArrayList<Movie> listaFilm = getBestMovies();
        model.addAttribute("movieList", listaFilm);
        return "movies";
    }

    // pagina lista canzoni
    @GetMapping("/songs")
    public String songs(Model model) {
        ArrayList<Song> listaCanzoni = getBestSongs();
        model.addAttribute("songList", listaCanzoni);
        return "songs";
    }

    @GetMapping("movies/{id}")
    public String getSingleMovie(Model model, @PathVariable("id") int id) {
        Movie movieContent = null;

        for (Movie movie : getBestMovies()) {
            if (movie.getId() == id) {
                movieContent = movie;
                break;
            }
        }
        
        model.addAttribute("id", id);
        model.addAttribute("movie", movieContent);
        return "singleMovie";
    }
    
    @GetMapping("songs/{id}")
    public String getSingleSong(Model model, @PathVariable("id") int id) {
        Song songContent = null;

        for (Song song : getBestSongs()) {
            if (song.getId() == id) {
                songContent = song;
                break;
            }
        }
        
        model.addAttribute("id", id);
        model.addAttribute("song", songContent);
        return "singleSong";
    }
    
}
