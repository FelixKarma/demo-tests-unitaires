import fr.diginamic.immobilier.entites.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MaisonTest {

    @Test
    void testAjouterPieceNominal() {
        Maison maison = new Maison();
        Piece piece = new Chambre(1, 15.0);

        maison.ajouterPiece(piece);

        assertEquals(1, maison.nbPieces(), "La maison devrait avoir 1 pièce.");
    }

    @Test
    void testAjouterPieceNull() {
        Maison maison = new Maison();

        maison.ajouterPiece(null);  // Cas où une pièce nulle est ajoutée

        assertEquals(0, maison.nbPieces(), "La maison ne devrait pas accepter de pièce nulle.");
    }

    @Test
    void testNbPieces() {
        Maison maison = new Maison();
        Piece piece1 = new Chambre(1, 12.0);
        Piece piece2 = new Salon(0, 20.0);

        maison.ajouterPiece(piece1);
        maison.ajouterPiece(piece2);

        assertEquals(2, maison.nbPieces(), "La maison devrait avoir 2 pièces.");
    }

    @Test
    void testSuperficieEtageNominal() {
        Maison maison = new Maison();
        Piece piece1 = new Chambre(1, 12.0);
        Piece piece2 = new Salon(1, 18.0);
        maison.ajouterPiece(piece1);
        maison.ajouterPiece(piece2);

        assertEquals(30.0, maison.superficieEtage(1), "La superficie totale de l'étage 1 devrait être 30.0.");
    }

    @Test
    void testSuperficieEtageInexistant() {
        Maison maison = new Maison();
        Piece piece1 = new Chambre(1, 12.0);
        Piece piece2 = new Salon(0, 20.0);
        maison.ajouterPiece(piece1);
        maison.ajouterPiece(piece2);

        assertEquals(0.0, maison.superficieEtage(2), "La superficie de l'étage inexistant devrait être 0.0.");
    }

    @Test
    void testSuperficieTypePieceNominal() {
        Maison maison = new Maison();
        Piece piece1 = new Chambre(1, 12.0);
        Piece piece2 = new Chambre(0, 10.0);
        Piece piece3 = new Salon(0, 20.0);

        maison.ajouterPiece(piece1);
        maison.ajouterPiece(piece2);
        maison.ajouterPiece(piece3);

        assertEquals(22.0, maison.superficieTypePiece("Chambre"), "La superficie totale des chambres devrait être 22.0.");
    }

    @Test
    void testSuperficieTypePieceInexistant() {
        Maison maison = new Maison();
        Piece piece = new Salon(0, 20.0);
        maison.ajouterPiece(piece);

        assertEquals(0.0, maison.superficieTypePiece("Cuisine"), "La superficie pour un type de pièce inexistant devrait être 0.0.");
    }

    @Test
    void testSuperficieTypePieceNull() {
        Maison maison = new Maison();
        Piece piece = new Salon(0, 20.0);
        maison.ajouterPiece(piece);

        assertEquals(0.0, maison.superficieTypePiece(null), "La superficie pour un type de pièce null devrait être 0.0.");
    }

    @Test
    void testCalculerSurfaceNominal() {
        Maison maison = new Maison();
        Piece piece1 = new Chambre(1, 12.0);
        Piece piece2 = new Salon(0, 20.0);

        maison.ajouterPiece(piece1);
        maison.ajouterPiece(piece2);

        assertEquals(32.0, maison.calculerSurface(), "La surface totale de la maison devrait être 32.0.");
    }

    @Test
    void testCalculerSurfaceVide() {
        Maison maison = new Maison();

        assertEquals(0.0, maison.calculerSurface(), "La surface totale d'une maison sans pièces devrait être 0.0.");
    }
}
