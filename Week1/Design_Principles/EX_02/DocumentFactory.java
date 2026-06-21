
abstract class DocumentFactory {

    // Factory Method

    public abstract Document createDocument();

    // Common operation

    public void openDocument() {

        Document document =
                createDocument();

        document.open();
    }
}