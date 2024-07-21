import app.utils.ServerJava;
import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UseCase1IntegrationTest {

    Javalin app = new ServerJava().javalinApp(); // inject any dependencies you might have

    String CREATE_URL = "/api/create";

    @Test
    void test_create_pikachu() throws IOException {

        String jsonContent = new String(Files.readAllBytes(Paths.get("src/test/resources/datasets/create_pikachu.json")));

        JavalinTest.test(app, (server, client) -> {
            assertThat(client.post(CREATE_URL, jsonContent).code()).isEqualTo(200);
        });
    }

    @Test
    void test_create_dracaufeu() throws IOException {
        String jsonContent = new String(Files.readAllBytes(Paths.get("src/test/resources/datasets/create_dracaufeu.json")));

        JavalinTest.test(app, (server, client) -> {
            assertThat(client.post(CREATE_URL, jsonContent).code()).isEqualTo(200);
        });
    }

    @Test
    void test_create_bulbizarre() throws IOException {
        String jsonContent = new String(Files.readAllBytes(Paths.get("src/test/resources/datasets/create_bulbizarre.json")));

        JavalinTest.test(app, (server, client) -> {
            assertThat(client.post(CREATE_URL, jsonContent).code()).isEqualTo(200);
        });
    }

    @Test
    void test_create_KO_bulbizarre_laready_in() throws IOException {
        String jsonContent = new String(Files.readAllBytes(Paths.get("src/test/resources/datasets/create_bulbizarre.json")));

        JavalinTest.test(app, (server, client) -> {
            assertThat(client.post(CREATE_URL, jsonContent).code()).isEqualTo(200);
            assertThat(client.post(CREATE_URL, jsonContent).code()).isEqualTo(400);
        });
    }

    @Test
    void test_create_KO_invalid_json() {

    }


}
