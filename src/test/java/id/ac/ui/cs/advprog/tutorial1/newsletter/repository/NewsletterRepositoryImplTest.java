package id.ac.ui.cs.advprog.tutorial1.newsletter.repository;

import id.ac.ui.cs.advprog.tutorial1.newsletter.core.Newsletter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsletterRepositoryImplTest {

    private NewsletterRepositoryImpl newsletterRepository = new NewsletterRepositoryImpl();

    @Test
    void testWhenGetAllReturnsArray() throws Exception {
        newsletterRepository.addNewsletter("BI Sports", new Newsletter("BI Sports"));
        newsletterRepository.addNewsletter("GameStart", new Newsletter("GameStart"));

        assertEquals(2, newsletterRepository.getAll().size());
    }

    @Test
    public void testWhenFindByNameCalledReturnTheNewsletterObject() throws Exception {

        newsletterRepository.addNewsletter("BI Sports", new Newsletter("BI Sports"));

        assertEquals("BI Sports", newsletterRepository.findByName("BI Sports").getName());

    }
}