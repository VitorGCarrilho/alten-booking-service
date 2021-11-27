package com.alten.bookingservice.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class CreateBookingRequestDTO {

    private LocalDate fromDate;
    private LocalDate untilDate;

    @Min(1)
    private int roomNumber;

    @NotNull(message = "email may not be null")
    @NotBlank(message = "email may not be blank")
    @Size(max=50)
    private String email;

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getUntilDate() {
        return untilDate;
    }

    public void setUntilDate(LocalDate untilDate) {
        this.untilDate = untilDate;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CreateBookingRequestDTO{" +
                "fromDate=" + fromDate +
                ", untilDate=" + untilDate +
                ", roomNumber=" + roomNumber +
                ", email='" + email + '\'' +
                '}';
    }
}
