package mkyong.java8;

import java.util.Optional;

public class Sock {
    Integer size;
    Optional<Sock> pair;
    
    public Integer getSize() {
        return size;
    }
    public void setSize(Integer size) {
        this.size = size;
    }
    public Optional<Sock> getPair() {
        return pair;
    }
    public void setPair(Optional<Sock> pair) {
        this.pair = pair;
    }
}
