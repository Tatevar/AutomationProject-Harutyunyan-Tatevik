package PageObject.herokuapp;

public enum HomePageLinksEnum {
    CONTEXT_MENU("Context Menu"),
    DYNAMIC_CONTROLS("Dynamic Controls"),
    FILE_UPLOADER("File Upload"),
    FRAMES("Frames"),
   FILEDOWNLOAD("File Download");

    String link;

    HomePageLinksEnum(String link) {
        this.link = link;
    }

    public String getLinkText() {
        return link;
    }
}
