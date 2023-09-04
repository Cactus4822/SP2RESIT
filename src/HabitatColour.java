public enum HabitatColour { //enum for all colours I need
    RESET("\u001b[0m"),
    BLANK("\u001b[48;5;255m"),
    RIVER("\u001b[104m"),
    FOREST("\u001b[48;5;22m"),
    WETLAND("\u001b[48;5;82m"),
    MOUNTAIN("\u001b[47;5m"),
    PRAIRIE("\u001b[48;5;226m"),
    HAWK("\u001b[38;5;4m"),
    BEAR("\u001b[38;5;94m"),
    ELK("\u001b[38;5;0m"),
    SALMON("\u001b[38;5;207m"),
    FOX("\u001b[38;5;208m"),
    HAWK_BG("\u001b[48;5;4m"),
    BEAR_BG("\u001b[48;5;94m"),
    ELK_BG("\u001b[48;5;0m"),
    SALMON_BG("\u001b[48;5;207m"),
    FOX_BG("\u001b[48;5;208m"),
    WHITE_TEXT("\u001b[97m"),
    WHITE("\u001b[107m"),
    KEY("\u001B[35m");

private String s;
    HabitatColour(String s) {
        this.s = s;
    }
    public String getColour () {
        return this.s;
    }

}
