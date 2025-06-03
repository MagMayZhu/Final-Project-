import javax.swing.*;
import java.util.List;

public class User
{
    private String name;
    private String bio;
    private ImageIcon image;
    private List<String> interests;

    public User(String name, String bio, ImageIcon image, List<String> interests)
    {
        this.name = name;
        this.bio = bio;
        this.image = image;
        this.interests = interests;
    }

    // Getters & setters
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getBio()
    {
        return bio;
    }

    public void setBio(String bio)
    {
        this.bio = bio;
    }

    public ImageIcon getImage()
    {
        return image;
    }

    public void setImage(ImageIcon image)
    {
        this.image = image;
    }

    public List<String> getInterests()
    {
        return interests;
    }

    public void setInterests(List<String> interests)
    {
        this.interests = interests;
    }
}
