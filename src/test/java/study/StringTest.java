package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");

        result = "1".split(",");
        assertThat(result).contains("1");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt")
    void charAt() {
        assertThrows(IndexOutOfBoundsException.class, () -> "abc".charAt(10));
        assertThatThrownBy(() -> "abc".charAt(10)).isInstanceOf(IndexOutOfBoundsException.class);
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(10));
    }

    @Test
    void testException() {
        assertThatThrownBy(() -> {
            throw new Exception("boom!");
        })
                .isInstanceOf(Exception.class)
                .hasMessageContaining("boom");

        assertThatExceptionOfType(IOException.class)
                .isThrownBy(() -> { throw new IOException("boom!"); })
                    .withMessage("%s!", "boom")
                    .withMessageContaining("boom")
                    .withNoCause();

        assertThatIOException().isThrownBy(() -> { throw new IOException("boom!"); })
                    .withMessage("%s!", "boom")
                    .withMessageContaining("boom")
                    .withNoCause();
    }

}
