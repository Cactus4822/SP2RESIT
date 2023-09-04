public class Tests {

    // simple tests for the scoring cards.

    public void salmonBearTest (Board b) {
        WildlifeToken sal = new WildlifeToken("Salmon");
        WildlifeToken bear = new WildlifeToken("Bear");

        starterTile st = new starterTile();
        b.tiles.add(st.s1t1);
        st.s1t1.setCoordinates(0,0);
        st.s1t1.setStringRep();
        b.tiles.add(st.s1t2);
        st.s1t2.setCoordinates(-1,1);
        st.s1t2.setStringRep();
        b.tiles.add(st.s1t3);
        st.s1t3.setCoordinates(0,1);
        st.s1t3.setStringRep();

        Tile s1 = new Tile(3, 5, new int[] {3, 4}, 0);
        b.tiles.add(s1);
        s1.setCoordinates(0,2);
        s1.setStringRep();
        Tile s2 = new Tile(3, 5, new int[] {3, 4}, 0);
        b.tiles.add(s2);
        s2.setCoordinates(1,2);
        s2.setStringRep();
        Tile s3 = new Tile(3, 5, new int[] {3, 4}, 0);
        b.tiles.add(s3);
        s3.setCoordinates(2,2);
        s3.setStringRep();
        Tile s4 = new Tile(3, 5, new int[] {3, 4}, 0);
        b.tiles.add(s4);
        s4.setCoordinates(2,1);
        s4.setStringRep();
        Tile s5 = new Tile(3, 5, new int[] {3, 4}, 0);
        b.tiles.add(s5);
        s5.setCoordinates(3,1);
        s5.setStringRep();
        Tile s6 = new Tile(3, 5, new int[] {3, 4}, 0);
        b.tiles.add(s6);
        s6.setCoordinates(4,2);
        s6.setStringRep();
        Tile b1 = new Tile(3, 5, new int[] {2, 4}, 0);
        b.tiles.add(b1);
        b1.setCoordinates(1,0);
        b1.setStringRep();
        Tile b2 = new Tile(3, 5, new int[] {2, 4}, 0);
        b.tiles.add(b2);
        b2.setCoordinates(-2,1);
        b2.setStringRep();
        Tile b3 = new Tile(3, 5, new int[] {2, 4}, 0);
        b.tiles.add(b3);
        b3.setCoordinates(-1,0);
        b3.setStringRep();

        st.s1t2.setWildlifeToken(sal);
        s1.setWildlifeToken(sal);
        s2.setWildlifeToken(sal);
        s3.setWildlifeToken(sal);
        s4.setWildlifeToken(sal);
        s5.setWildlifeToken(sal);
        s6.setWildlifeToken(sal);
        st.s1t3.setWildlifeToken(bear);
        b1.setWildlifeToken(bear);
        b2.setWildlifeToken(bear);
        b3.setWildlifeToken(bear);

    }

    public void elkHawkTest (Board b) {
        WildlifeToken elk = new WildlifeToken("Elk");
        WildlifeToken hawk = new WildlifeToken("Hawk");


        starterTile st = new starterTile();
        b.tiles.add(st.s1t1);
        st.s1t1.setCoordinates(0,0);
        st.s1t1.setStringRep();
        b.tiles.add(st.s1t2);
        st.s1t2.setCoordinates(-1,1);
        st.s1t2.setStringRep();
        b.tiles.add(st.s1t3);
        st.s1t3.setCoordinates(0,1);
        st.s1t3.setStringRep();

        Tile e1 = new Tile(3, 5, new int[] {3, 4}, 0);
        b.tiles.add(e1);
        e1.setCoordinates(0,2);
        e1.setStringRep();
        Tile e2 = new Tile(3, 5, new int[] {3, 4}, 0);
        b.tiles.add(e2);
        e2.setCoordinates(1,2);
        e2.setStringRep();
        Tile e3 = new Tile(3, 5, new int[] {3, 4}, 0);
        b.tiles.add(e3);
        e3.setCoordinates(2,2);
        e3.setStringRep();
        Tile e4 = new Tile(3, 5, new int[] {3, 4}, 0);
        b.tiles.add(e4);
        e4.setCoordinates(3,2);
        e4.setStringRep();

        e1.setWildlifeToken(elk);
        e2.setWildlifeToken(elk);
        e3.setWildlifeToken(elk);
        e4.setWildlifeToken(elk);
        st.s1t2.setWildlifeToken(hawk);

    }

    public void foxTest (Board b) {
        WildlifeToken fox = new WildlifeToken("Fox");
        WildlifeToken elk = new WildlifeToken("Elk");
        WildlifeToken hawk = new WildlifeToken("Hawk");
        WildlifeToken sal = new WildlifeToken("Salmon");
        WildlifeToken bear = new WildlifeToken("Bear");

        starterTile st = new starterTile();
        b.tiles.add(st.s1t1);
        st.s1t1.setCoordinates(0,0);
        st.s1t1.setStringRep();
        b.tiles.add(st.s1t2);
        st.s1t2.setCoordinates(-1,1);
        st.s1t2.setStringRep();
        b.tiles.add(st.s1t3);
        st.s1t3.setCoordinates(0,1);
        st.s1t3.setStringRep();

        Tile f1 = new Tile(3, 5, new int[] {3, 5}, 0);
        b.tiles.add(f1);
        f1.setCoordinates(0,2);
        f1.setStringRep();
        Tile f2 = new Tile(3, 5, new int[] {3, 5}, 0);
        b.tiles.add(f2);
        f2.setCoordinates(1,2);
        f2.setStringRep();
        Tile f3 = new Tile(3, 5, new int[] {2, 4}, 0);
        b.tiles.add(f3);
        f3.setCoordinates(1,0);
        f3.setStringRep();
        Tile f4 = new Tile(3, 5, new int[] {2, 4}, 0);
        b.tiles.add(f4);
        f4.setCoordinates(1,1);
        f4.setStringRep();
        Tile f5 = new Tile(3, 5, new int[] {2, 5}, 0);
        b.tiles.add(f5);
        f5.setCoordinates(-1,2);
        f5.setStringRep();
        Tile f6 = new Tile(3, 5, new int[] {1, 4}, 0);
        b.tiles.add(f6);
        f6.setCoordinates(0,3);
        f6.setStringRep();
        Tile f7 = new Tile(3, 5, new int[] {2, 4}, 0);
        b.tiles.add(f7);
        f7.setCoordinates(-1,3);
        f7.setStringRep();

        f1.setWildlifeToken(fox);
        f2.setWildlifeToken(elk);
        f3.setWildlifeToken(sal);
        f4.setWildlifeToken(bear);
        st.s1t1.setWildlifeToken(hawk);
        st.s1t2.setWildlifeToken(sal);
        st.s1t3.setWildlifeToken(fox);
        f5.setWildlifeToken(bear);
        f6.setWildlifeToken(hawk);
        f7.setWildlifeToken(sal);
    }

}
