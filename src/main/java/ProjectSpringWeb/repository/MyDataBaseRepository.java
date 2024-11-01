package ProjectSpringWeb.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MyDataBaseRepository {
    public String getDataFromRepository(){return "This is the data from database";}
}
