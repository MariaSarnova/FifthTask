package com.epam.task.fifth.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Composite implements Component{
    private List<Component> components=new ArrayList<>();

    public Composite(){

    }

    public Composite(List<Component> components){
        this.components=components;
    }

    public void addComponent(Component component){
        components.add(component);
    }

    public boolean removeComponent(Component component){
        return components.remove(component);
    }

    public int getAmountOfComponents(){
        return components.size();
    }

    public Component getComponent(int index){
        return index<this.getAmountOfComponents()?components.get(index):null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Composite composite = (Composite) o;
        return Objects.equals(components, composite.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }

    @Override
    public String toString() {
        return "Composite{" +
                "components=" + components +
                '}';
    }
}
