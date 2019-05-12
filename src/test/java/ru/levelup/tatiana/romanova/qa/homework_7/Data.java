package ru.levelup.tatiana.romanova.qa.homework_7;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class Data {

    public User user;
    public Project project;
    public Issue issue;
    public SubProject subProject;
    public Issue updatedIssue;
    public Properties properties;

    @BeforeClass(alwaysRun = true)
    protected void InitializeData() {

        ObjectMapper mapper = new ObjectMapper();
        properties = new Properties();
        try {
             properties.load(new FileInputStream(new File("src/test/resources/homework_7/test.data")));
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



