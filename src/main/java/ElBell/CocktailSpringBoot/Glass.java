package ElBell.CocktailSpringBoot;

import java.net.URL;

public class Glass {
    private Integer glassId;
    private String glassName;
    private URL glassImage;

    public Glass(Integer glassId, String glassName, URL glassImage) {
        this.glassId = glassId;
        this.glassName = glassName;
        this.glassImage = glassImage;
    }

    public Integer getGlassId() {
        return glassId;
    }

    public void setGlassId(Integer glassId) {
        this.glassId = glassId;
    }

    public String getGlassName() {
        return glassName;
    }

    public void setGlassName(String glassName) {
        this.glassName = glassName;
    }

    public URL getGlassImage() {
        return glassImage;
    }

    public void setGlassImage(URL glassImage) {
        this.glassImage = glassImage;
    }
}
