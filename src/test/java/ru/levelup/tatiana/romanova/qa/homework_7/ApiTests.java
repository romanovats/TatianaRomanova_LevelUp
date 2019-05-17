package ru.levelup.tatiana.romanova.qa.homework_7;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

public class ApiTests extends Data {

    //Создание пользователя
    @Test
    // TODO Наименование методов(
    public void CreateUserTest(){
        RequestSpecification request =
            given()
                .baseUri("http://khda91.fvds.ru/mantisbt/api/rest")
                .header(new Header("Authorization", "XNd5tIXXB7U8FV4C8w0nao0WYr5S0nN7"))
                .contentType(ContentType.JSON)
                .body(user);

        Response response = request
            .when()
                .post("/users");

        String statusLine = response
            .then()
                .statusCode(201)
                .statusLine(containsString("User created with id"))
                .extract()
                .statusLine();

        String[] splitStatusLine = statusLine.split(" ");
        String userId = splitStatusLine[splitStatusLine.length - 1];
        System.out.println("created user id -> " + userId);
    }

    //Создание проекта
    @Test
    // TODO Наименование методов(
    public void CreateProjectTest(){
        RequestSpecification request =
                given()
                        .baseUri("http://khda91.fvds.ru/mantisbt/api/rest")
                        .header(new Header("Authorization", "XNd5tIXXB7U8FV4C8w0nao0WYr5S0nN7"))
                        .contentType(ContentType.JSON)
                        .body(project);

        Response response = request
                .when()
                .post("/projects/");

        String statusLine = response
                .then()
                .statusCode(201)
                .statusLine(containsString("Project created with id"))
                .extract()
                .statusLine();

        String[] splitStatusLine = statusLine.split(" ");
        String projectId = splitStatusLine[splitStatusLine.length - 1];
        System.out.println("created project id -> " + projectId);
    }

    //Создание issue с attachments
    @Test
    // TODO Наименование методов(
    public void CreateIssueWithAttachmentsTest(){
        RequestSpecification request =
                given()
                        .baseUri("http://khda91.fvds.ru/mantisbt/api/rest")
                        .header(new Header("Authorization", "XNd5tIXXB7U8FV4C8w0nao0WYr5S0nN7"))
                        .contentType(ContentType.JSON)
                        .body(issue);

        Response response = request
                .when()
                .post("/issues/");

        String statusLine = response
                .then()
                .statusCode(201)
                .extract()
                .statusLine();

        String[] splitStatusLine = statusLine.split(" ");
        String issueId = splitStatusLine[splitStatusLine.length - 1];
        System.out.println("created issue id -> " + issueId);
    }

    //удаление созданного пользователя
    @Test
    // TODO Наименование методов(
    public void DeleteUserTest(){
        RequestSpecification request =
                given()
                        .baseUri("http://khda91.fvds.ru/mantisbt/api/rest")
                        .header(new Header("Authorization", "XNd5tIXXB7U8FV4C8w0nao0WYr5S0nN7"));

        Response response = request
                .when()
                .delete("/users/"+properties.getProperty("deletedUserId"));

        response
                .then()
                .statusCode(204);
    }

    //добавление подпроекта к проекту
    @Test
    // TODO Наименование методов(
    public void CreateSubProjectTest(){

        RequestSpecification request =
                given()
                        .baseUri("http://khda91.fvds.ru/mantisbt/api/rest")
                        .header(new Header("Authorization", "XNd5tIXXB7U8FV4C8w0nao0WYr5S0nN7"))
                        .contentType(ContentType.JSON)
                        .body(subProject);

        Response response = request
                .when()
                .post("/projects/"+properties.getProperty("projectId")+"/subprojects");

        String statusLine =  response
                .then()
                .statusCode(204)
                .statusLine(containsString("added to project"))
                .extract()
                .statusLine();
    }

    //обновление issue
    @Test
    // TODO Наименование методов(
    public void UpdateIssueTest(){
        RequestSpecification request =
                given()
                        .baseUri("http://khda91.fvds.ru/mantisbt/api/rest")
                        .header(new Header("Authorization", "XNd5tIXXB7U8FV4C8w0nao0WYr5S0nN7"))
                        .contentType(ContentType.JSON)
                        .body(updatedIssue);

        Response response = request
                .when()
                .patch("/issues/"+properties.getProperty("issueId"));

        String statusLine = response
                .then()
                .statusCode(200)
                .extract()
                .statusLine();

        String[] splitStatusLine = statusLine.split(" ");
        String updatedIssueId = splitStatusLine[splitStatusLine.length - 1];
        System.out.println("updated issue id -> " + updatedIssueId);
    }

    //обновление несуществующего issue
    @Test
    // TODO Наименование методов(
    public void UpdateNonexistentIssueTest(){
        RequestSpecification request =
                given()
                        .baseUri("http://khda91.fvds.ru/mantisbt/api/rest")
                        .header(new Header("Authorization", "XNd5tIXXB7U8FV4C8w0nao0WYr5S0nN7"))
                        .contentType(ContentType.JSON)
                        .body(issue);

        Response response = request
                .when()
                .patch("/issues/"+properties.getProperty("nonexistentIssueId"));

        String statusLine = response
                .then()
                .statusCode(404)
                .extract()
                .statusLine();

        System.out.println(statusLine);
    }

    //удаление несуществующего проекта
    @Test
    // TODO Наименование методов(
    public void DeleteNonexistentProjectTest(){
        RequestSpecification request =
                given()
                        .baseUri("http://khda91.fvds.ru/mantisbt/api/rest")
                        .header(new Header("Authorization", "XNd5tIXXB7U8FV4C8w0nao0WYr5S0nN7"))
                        .contentType(ContentType.JSON);

        Response response = request
                .when()
                .delete("/projects/"+properties.getProperty("nonexistentProjectId"));

        String statusLine = response
                .then()
                .statusCode(403)
                .extract()
                .statusLine();

        System.out.println(statusLine);
    }

    //Удаление несуществующего пользователя
    @Test
    // TODO Наименование методов(
    public void DeleteNonexistentUserTest(){
        RequestSpecification request =
                given()
                        .baseUri("http://khda91.fvds.ru/mantisbt/api/rest")
                        .header(new Header("Authorization", "XNd5tIXXB7U8FV4C8w0nao0WYr5S0nN7"));

        Response response = request
                .when()
                .delete("/users/"+properties.getProperty("nonexistentUserId"));

        String statusLine = response
                .then()
                .statusCode(404)
                .extract()
                .statusLine();

        System.out.println(statusLine);
    }
}
