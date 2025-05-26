package com.polytechnique.tpfinalpoo2.services.gestion;

import com.polytechnique.tpfinalpoo2.models.Evenement;
import com.polytechnique.tpfinalpoo2.models.Participant;
import com.polytechnique.tpfinalpoo2.sauvegarde.SauvegardeParticipant;
import com.polytechnique.tpfinalpoo2.sauvegarde.SauvegardeParticipantOfEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GestionParticipantTest {

    private Map<String, Participant> participants;
    private Map<String, ArrayList<String>> participantOfEvent;

    private Participant participant;
    private Evenement evenement;

    @BeforeEach
    public void setup() {
        participants = new HashMap<>();
        participantOfEvent = new HashMap<>();

        participant = new Participant("1", "Alice", "alice@example.com");
        evenement = new Evenement("E1", "Conférence IA", 100);
        participantOfEvent.put(evenement.getId(), new ArrayList<>());
    }

    @Test
    public void testAjouterParticipant() {
        try (
                MockedStatic<SauvegardeParticipant> spMock = mockStatic(SauvegardeParticipant.class);
                MockedStatic<SauvegardeParticipantOfEvent> spoeMock = mockStatic(SauvegardeParticipantOfEvent.class)
        ) {
            // Mock des singletons
            SauvegardeParticipant mockSP = mock(SauvegardeParticipant.class);
            when(mockSP.charger()).thenReturn(participants);
            spMock.when(SauvegardeParticipant::getInstance).thenReturn(mockSP);

            SauvegardeParticipantOfEvent mockSPOE = mock(SauvegardeParticipantOfEvent.class);
            when(mockSPOE.charger()).thenReturn(participantOfEvent);
            spoeMock.when(SauvegardeParticipantOfEvent::getInstance).thenReturn(mockSPOE);

            // Créer l’objet à tester
            GestionParticipant gp = GestionParticipant.getInstance();
            boolean result = gp.ajouterParticipant(participant, evenement);

            assertTrue(result);
            assertEquals(1, participants.size());
            assertEquals(participant, gp.rechercherParticipant(participant.getId()));
            verify(mockSP).sauvegarder(any());
            verify(mockSPOE).sauvegarder(any());
        }
    }

    @Test
    public void testRechercherParticipantInexistant() {
        try (
                MockedStatic<SauvegardeParticipant> spMock = mockStatic(SauvegardeParticipant.class);
                MockedStatic<SauvegardeParticipantOfEvent> spoeMock = mockStatic(SauvegardeParticipantOfEvent.class)
        ) {
            SauvegardeParticipant mockSP = mock(SauvegardeParticipant.class);
            when(mockSP.charger()).thenReturn(participants);
            spMock.when(SauvegardeParticipant::getInstance).thenReturn(mockSP);

            SauvegardeParticipantOfEvent mockSPOE = mock(SauvegardeParticipantOfEvent.class);
            when(mockSPOE.charger()).thenReturn(participantOfEvent);
            spoeMock.when(SauvegardeParticipantOfEvent::getInstance).thenReturn(mockSPOE);

            GestionParticipant gp = GestionParticipant.getInstance();
            assertNull(gp.rechercherParticipant("42"));
        }
    }
}
