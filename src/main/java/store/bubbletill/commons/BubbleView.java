package store.bubbletill.commons;

public interface BubbleView {

    void show(); // When the view is requested to be shown - e.g. show the home pane and setup any data
    void hide(); // WHen the view is requested to be hidden - hide everything and reset!

}
