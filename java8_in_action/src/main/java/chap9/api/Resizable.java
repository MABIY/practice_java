package chap9.api;

/**
 * @author : lh
 * @since : 2020/6/8, Mon
 **/
public interface Resizable extends Drawable {
    int getWidth();

    int getHeight();

    void setWidth(int width);

    void setHeight(int height);

    void setAbsoluteSize(int width, int height);
}
