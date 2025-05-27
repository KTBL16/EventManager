package com.polytechnique.tpfinalpoo2.gestion;

import com.polytechnique.tpfinalpoo2.models.Conference;
import com.polytechnique.tpfinalpoo2.models.Evenement;
import com.polytechnique.tpfinalpoo2.sauvegarde.SauvegardeEvenement;
import com.polytechnique.tpfinalpoo2.services.gestion.GestionEvenements;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GestionEvenementTest {

    private GestionEvenements gestion;
    private SauvegardeEvenement sauvegardeMock;

    @BeforeEach
    void setUp() {
        resetSingleton();

        // Créer un mock de SauvegardeEvenement
        sauvegardeMock = mock(SauvegardeEvenement.class);
        when(sauvegardeMock.charger()).thenReturn(new HashMap<>());

        // Injecter le mock
        SauvegardeEvenementTestAccessoir.setMockInstance(sauvegardeMock);

        gestion = GestionEvenements.getInstance();
    }

    @Test
    void testAjouterEvenement_success() {
        // Given
        Evenement event = evenementTest();

        // When
        gestion.ajouterEvenement(event);

        // Then
        assertEquals(event, gestion.rechercherEvenement("E1"));
        verify(sauvegardeMock, atLeastOnce()).sauvegarder(anyMap());
    }

    @Test
    void testSupprimerEvenement_success() {
        // Given
        Evenement event = evenementTest();
        gestion.ajouterEvenement(event);
        assertNotNull(gestion.rechercherEvenement("E1"));

        // When
        gestion.supprimerEvenement("E1");

        // Then
        assertNull(gestion.rechercherEvenement("E1"));
        verify(sauvegardeMock, atLeast(2)).sauvegarder(anyMap()); // Une fois pour ajout, une fois pour suppression
    }

    @Test
    void testRechercherEvenement_found() {
        // Given
        Evenement event = evenementTest();
        gestion.ajouterEvenement(event);

        // When
        Evenement found = gestion.rechercherEvenement("E1");

        // Then
        assertNotNull(found);
        assertEquals("Conférence Tech", found.getNom());
    }

    @Test
    void testRechercherEvenement_notFound() {
        assertNull(gestion.rechercherEvenement("E999"));
    }

    @Test
    void testEditerEvenement_success() {
        // Given
        Evenement event = evenementTest();
        gestion.ajouterEvenement(event);

        // New version with same ID
        Evenement updated = new Conference("E1", "Conférence Modifiée", LocalDateTime.now(), "Salle B", 200, "Tech", List.of("New Speaker"));

        // When
        gestion.editerEvenement(updated);

        // Then
        Evenement result = gestion.rechercherEvenement("E1");
        assertNotNull(result);
        assertEquals("Conférence Modifiée", result.getNom());
        assertEquals("Salle B", result.getLieu());
        verify(sauvegardeMock, atLeast(2)).sauvegarder(anyMap()); // suppression + ajout
    }

    // Utilitaire pour créer un événement de test
    private Evenement evenementTest() {
        return new Conference("E1", "Conférence Tech", LocalDateTime.of(2025, 6, 1, 18, 0), "Amphithéâtre A", 100, "Technologie", List.of("Alice", "Bob"));
    }

    // Utilitaire pour reset le singleton entre les tests
    private void resetSingleton() {
        try {
            var field = GestionEvenements.class.getDeclaredField("instance");
            field.setAccessible(true);
            field.set(null, null);
        } catch (Exception e) {
            throw new RuntimeException("Erreur reset singleton", e);
        }
    }
}


