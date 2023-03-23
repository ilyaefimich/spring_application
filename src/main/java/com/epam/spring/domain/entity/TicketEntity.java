package com.epam.spring.domain.entity;

public class TicketEntity {

    private long ticketId;
    private int place;
    private long userId;
    private long eventId;
    private Category category;

    public TicketEntity() {
    }

    public TicketEntity(long ticketId, int place, long userId, long eventId, Category category) {
        this.ticketId = ticketId;
        this.place = place;
        this.userId = userId;
        this.eventId = eventId;
        this.category = category;
    }

    @Override
    public String toString() {
        return "TicketEntity{" +
                "ticketId=" + ticketId +
                ", place=" + place +
                ", userId=" + userId +
                ", eventId=" + eventId +
                ", category=" + category +
                '}';
    }

    public long getId() {
        return ticketId;
    }

    public void setId(long id) {
        this.ticketId = id;
    }

    public long getEventId() {
        return eventId;
    }

    public long getUserId() {
        return userId;
    }

    public Category getCategory() {
        return category;
    }

    public int getPlace() {
        return place;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketEntity that = (TicketEntity) o;
        if (ticketId != that.ticketId) return false;
        if (getPlace() != that.getPlace()) return false;
        if (getUserId() != that.getUserId()) return false;
        if (getEventId() != that.getEventId()) return false;
        return getCategory() == that.getCategory();
    }

    public int hashCode() {
        int result = (int) (ticketId ^ (ticketId >>> 32));
        result = 31 * result + getPlace();
        result = 31 * result + (int) (getUserId() ^ (getUserId() >>> 32));
        result = 31 * result + (int) (getEventId() ^ (getEventId() >>> 32));
        result = 31 * result + getCategory().hashCode();
        return result;
    }

    public enum Category {STANDARD, PREMIUM, BAR}

    public static class Builder {
        private long ticketId;
        private long userId;
        private long eventId;
        private Category category;
        private int place;

        public Builder setPlace(int place) {
            this.place = place;
            return this;
        }

        public Builder setUserId(long userId) {
            this.userId = userId;
            return this;
        }

        public Builder setEventId(long eventId) {
            this.eventId = eventId;
            return this;
        }

        public Builder setCategory(Category category) {
            this.category = category;
            return this;
        }

        public Builder setId(long id) {
            this.ticketId = id;
            return this;
        }

        public TicketEntity build() {
            return new TicketEntity(ticketId, place, userId, eventId, category);
        }
    }

}
