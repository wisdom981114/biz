package com.capstone.teamProj_10.apiTest.valTable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
public class ValTable {
    @Id
    @Column(name ="prog_No")
    private Long progrmRegistNo;

    @Column(nullable = false)
    private int gugunCd;//시군구 코드
    @Column(nullable = false)
    private int sidoCd;//시도 코드

    private int progrmBgnde;
    private int progrmEndde;
    @Column(nullable = false)
    private String progrmSj;
    private int progrmSttusSe;


    public ValTable(TableDto tableDto) {
        this.progrmRegistNo = tableDto.getProgrmRegistNo();
        this.gugunCd = tableDto.getGugunCd();
        this.sidoCd = tableDto.getSidoCd();
        this.progrmBgnde = tableDto.getProgrmBgnde();
        this.progrmEndde = tableDto.getProgrmEndde();
        this.progrmSj = tableDto.getProgrmSj();
        this.progrmSttusSe = tableDto.getProgrmSttusSe();

    }
}
