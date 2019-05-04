package ru.levelup.tatiana.romanova.qa.homework_7;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

public abstract class Data {

    public User user;
    public Project project;
    public Issue issue;
    public SubProject subProject;
    public Issue updatedIssue;

    @BeforeTest(alwaysRun = true)
    protected void InitializeData() {

        ObjectMapper mapper = new ObjectMapper();
        try {
             user = mapper.readValue(new File("src/test/resources/homework_7/users.json"), User.class);
             project = mapper.readValue(new File("src/test/resources/homework_7/projects.json"), Project.class);
             issue = mapper.readValue(new File("src/test/resources/homework_7/issues.json"), Issue.class);
             subProject = mapper.readValue(new File("src/test/resources/homework_7/subproject.json"), SubProject.class);
             updatedIssue = mapper.readValue(new File("src/test/resources/homework_7/updatedissues.json"), Issue.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



