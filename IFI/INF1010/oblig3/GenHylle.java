interface GenHylle<T>{

    public int genHylleStoerrelse();

    public void settPaaPlass(T objekt, int plass);

    public boolean sjekkLedig(int plass);

}
