package promowarn.version3;

public interface PromotionWithDelegate extends Promotion {
    Student delegate();

    void chooseDelegate(final Student e);
}
