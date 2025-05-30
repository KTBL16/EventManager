package com.polytechnique.tpfinalpoo2.gestion;

public class GestionParticipantTest {
//
//    private Map<String, Participant> participant;
//    private Map<String, ArrayList<String>> participantOfEvent;
//
//
//    Participant p = new Participant("1", "Alice", "alice@example.com", "allice123");
//    Evenement e = new Concert("E1", "Conférence IA", LocalDateTime.of(2025, 10, 25, 14, 30),"polytechnique", 100, "Lagrange", "SchoolSlam");
//
//    @BeforeEach
//    void setUp() {
//        participant = new HashMap<>();
//        participantOfEvent = new HashMap<>();
//    }
//
//    @Test
//    void testAjouterSimpleParticipant_success() {
//
//        try (MockedStatic<SauvegardeParticipant> mocked = mockStatic(SauvegardeParticipant.class)) {
//            SauvegardeParticipant spMock = mock(SauvegardeParticipant.class);
//            when(spMock.charger()).thenReturn(participant);
//            mocked.when(SauvegardeParticipant::getInstance).thenReturn(spMock);
//
//            GestionParticipant gestion = GestionParticipant.getInstance();
//
//            boolean result = gestion.ajouterSimpleParticipant(p);
//
//            assertTrue(result);
//            assertEquals(p, participant.get("1"));
//            verify(spMock).sauvegarder(participant);
//        }
//    }
//
//    @Test
//    void testAjouterSimpleParticipant_dejaExistant() {
//        Participant p = new Participant("1", "Alice", "alice@example.com", "allice123");
//        participant.put("1", p);
//
//        try (MockedStatic<SauvegardeParticipant> mocked = mockStatic(SauvegardeParticipant.class)) {
//            SauvegardeParticipant spMock = mock(SauvegardeParticipant.class);
//            when(spMock.charger()).thenReturn(participant);
//            mocked.when(SauvegardeParticipant::getInstance).thenReturn(spMock);
//
//            GestionParticipant gestion = GestionParticipant.getInstance();
//
//            boolean result = gestion.ajouterSimpleParticipant(p);
//
//            assertFalse(result);
//            verify(spMock, never()).sauvegarder(any());
//        }
//    }
//
//    @Test
//    void testAjouterParticipantAvecEvenement_success() {
//        Participant p = new Participant("1", "Alice", "alice@example.com", "allice123");
//        participantOfEvent.put("E1", new ArrayList<>());
//
//        try (MockedStatic<SauvegardeParticipantOfEvent> mocked = mockStatic(SauvegardeParticipantOfEvent.class)) {
//            SauvegardeParticipantOfEvent spMock = mock(SauvegardeParticipantOfEvent.class);
//            when(spMock.charger()).thenReturn(participantOfEvent);
//            mocked.when(SauvegardeParticipantOfEvent::getInstance).thenReturn(spMock);
//
//            GestionParticipant gestion = GestionParticipant.getInstance();
//
//            boolean result = gestion.ajouterParticipant(p, e);
//
//            assertTrue(result);
//            assertTrue(participantOfEvent.get("E1").contains("1"));
//            verify(spMock).sauvegarder(participantOfEvent);
//        }
//    }
//
//    @Test
//    void testAjouterParticipantAvecEvenement_capaciteMaxAtteinte() {
//        Evenement e = new Concert("E2", "djazz day", LocalDateTime.of(2025, 10, 25, 15, 30),"polytechnique", 1, "Lagrange", "SchoolSlam");
//        participantOfEvent.put("E1", new ArrayList<>());
//        participantOfEvent.put("E2", new ArrayList<>());
//
//        try (MockedStatic<SauvegardeParticipantOfEvent> mocked = mockStatic(SauvegardeParticipantOfEvent.class)) {
//            SauvegardeParticipantOfEvent spMock = mock(SauvegardeParticipantOfEvent.class);
//            when(spMock.charger()).thenReturn(participantOfEvent);
//            mocked.when(SauvegardeParticipantOfEvent::getInstance).thenReturn(spMock);
//
//            GestionParticipant gestion = GestionParticipant.getInstance();
//
//            boolean result = gestion.ajouterParticipant(
//                    new Participant("P3", "Claire", "claire@mail.com", "claire123"), e
//            );
//
//            // Comme participantOfEvent contient déjà 2 événements, et e.capacitéMax == 1 → refus
//            assertFalse(result);
//            verify(spMock, never()).sauvegarder(any());
//        }
//    }
//
//    @Test
//    public void testSupprimerParticipant() {
//        try (
//                MockedStatic<SauvegardeParticipant> spMock = mockStatic(SauvegardeParticipant.class);
//                MockedStatic<SauvegardeParticipantOfEvent> spoeMock = mockStatic(SauvegardeParticipantOfEvent.class)
//        ) {
//    //            // 1. Création des participants et événements simulés
//    //            Participant p = new Participant("1", "Alice", "alice@example.com");
//    //            Evenement e = new Evenement("E1", "Conférence IA", 100);
//
//            Map<String, Participant> participantsMap = new HashMap<>();
//            participantsMap.put(p.getId(), p);
//
//            ArrayList<String> ids = new ArrayList<>();
//            ids.add(p.getId());
//            Map<String, ArrayList<String>> participantOfEventMap = new HashMap<>();
//            participantOfEventMap.put(e.getId(), ids);
//
//            // 2. Mocks des classes de sauvegarde
//            SauvegardeParticipant mockSP = mock(SauvegardeParticipant.class);
//            when(mockSP.charger()).thenReturn(participantsMap);
//            spMock.when(SauvegardeParticipant::getInstance).thenReturn(mockSP);
//
//            SauvegardeParticipantOfEvent mockSPOE = mock(SauvegardeParticipantOfEvent.class);
//            when(mockSPOE.charger()).thenReturn(participantOfEventMap);
//            spoeMock.when(SauvegardeParticipantOfEvent::getInstance).thenReturn(mockSPOE);
//
//            // 3. Initialisation du gestionnaire
//            // NB : si GestionParticipant est déjà instancié ailleurs, ça pourrait être un problème. Il faudra prévoir un moyen de réinitialiser le singleton en test.
//            GestionParticipant gp = GestionParticipant.getInstance();
//
//            // 4. Exécution de la suppression
//            gp.supprimerParticipant(p.getId());
//
//            // 5. Assertions : vérifie que le participant est supprimé
//            assertNull(gp.rechercherParticipant(p.getId()));
//            assertFalse(participantOfEventMap.get(e.getId()).contains(p.getId()));
//
//            // 6. Vérifie que les méthodes de sauvegarde ont été appelées
//            verify(mockSP).sauvegarder(any());
//            verify(mockSPOE).sauvegarder(any());
//        }
//    }
//
//    @Test
//    public void testRechercherParticipantInexistant() {
//        try (
//                MockedStatic<SauvegardeParticipant> spMock = mockStatic(SauvegardeParticipant.class);
//                MockedStatic<SauvegardeParticipantOfEvent> spoeMock = mockStatic(SauvegardeParticipantOfEvent.class)
//        ) {
//            SauvegardeParticipant mockSP = mock(SauvegardeParticipant.class);
//            when(mockSP.charger()).thenReturn(participant);
//            spMock.when(SauvegardeParticipant::getInstance).thenReturn(mockSP);
//
//            SauvegardeParticipantOfEvent mockSPOE = mock(SauvegardeParticipantOfEvent.class);
//            when(mockSPOE.charger()).thenReturn(participantOfEvent);
//            spoeMock.when(SauvegardeParticipantOfEvent::getInstance).thenReturn(mockSPOE);
//
//            GestionParticipant gp = GestionParticipant.getInstance();
//            assertNull(gp.rechercherParticipant("42"));
//        }
//    }
}



