package inicial_scaffolding.Service;

import inicial_scaffolding.entities.CardEntity;
import inicial_scaffolding.repositories.CardRepository;
import inicial_scaffolding.services.imp.CardServiceImp;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest
public class Imp {

    @SpyBean
    private CardServiceImp cardServiceImp;

    @MockBean
    private CardRepository cardRepository;

    @Test
    public void testGetAllCards() {
        // Arrange
        CardEntity card1 = new CardEntity();
        CardEntity card2 = new CardEntity();
        List<CardEntity> cardList = Arrays.asList(card1, card2);

        when(cardRepository.findAll()).thenReturn(cardList);

        // Act
        List<CardEntity> result = cardServiceImp.getAllCards();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(cardRepository, times(1)).findAll();
    }

    @Test
    public void testGetAllCards_NotFound() {
        // Arrange
        when(cardRepository.findAll()).thenReturn(null);

        // Act & Assert
        HttpClientErrorException exception = assertThrows(HttpClientErrorException.class, () -> {
            cardServiceImp.getAllCards();
        });

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
        verify(cardRepository, times(1)).findAll();
    }
}
