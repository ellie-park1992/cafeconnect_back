package com.kong.cc.dto;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.kong.cc.entity.Member;
import com.kong.cc.entity.Store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreDto {
	private Integer storeCode;
	
	private String storeName;
	private String storeAddress;
	private String storeAddressNum;
	private String storePhone;
	
	@JsonSerialize(using = LocalDateTimeSerializer.class) // 직렬화 시 필요
	@JsonDeserialize(using = LocalDateTimeDeserializer.class) // 역직렬화 시 필요
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd kk:mm:ss") // 원하는 형태의 LocalDateTime 설정
	private LocalDateTime storeOpenTime;
	@JsonSerialize(using = LocalDateTimeSerializer.class) // 직렬화 시 필요
	@JsonDeserialize(using = LocalDateTimeDeserializer.class) // 역직렬화 시 필요
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd kk:mm:ss") // 원하는 형태의 LocalDateTime 설정
	private LocalDateTime storeCloseTime;
	private String storeCloseDate;
	
	private String ownerName;
	private String ownerPhone;
	private String managerName;
	private String managerPhone;
	
	private Date contractPeriodStart;
	private Date contractPeriodEnd;
	private Date contractDate;
	private Date openingDate;
	private String storeStatus;
	 
	private Integer memberNum;
	
	// 추가
	private Integer stockCount;
	
	public Store toEntity() {
		Store store = Store.builder()
				.storeCode(storeCode)
				.storeName(storeName)
				.storeAddress(storeAddress)
				.storeAddressNum(storeAddressNum)
				.storeCode(storeCode)
				.storeName(storeName)
				.storeAddress(storeAddress)
				.storePhone(storePhone)
				.storeOpenTime(storeOpenTime)
				.storeCloseTime(storeCloseTime)
				.storeCloseDate(storeCloseDate)
				.ownerName(ownerName)
				.ownerPhone(ownerPhone)
				.managerName(managerName)
				.managerPhone(managerPhone)
				.contractPeriodStart(contractPeriodStart)
				.contractPeriodEnd(contractPeriodEnd)
				.contractDate(contractDate)
				.openingDate(openingDate)
				.storeStatus(storeStatus)
				.member(Member.builder().memberNum(memberNum).build())
				.build();
		return store;
	}
}
