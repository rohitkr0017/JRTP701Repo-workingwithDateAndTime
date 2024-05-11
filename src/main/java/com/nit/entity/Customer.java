package com.nit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "CUSTOMER")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer {
	@Column(name = "CID")
	@Id
	//@GeneratedValue		//generate the id values 1,2,52,102,152, etc
	@SequenceGenerator(name = "gen1",sequenceName = "CNO_SEQ",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer cno;
	@NonNull
	@Column(name = "CNAME", length = 20)
	private String cname;
	@NonNull
	@Column(name = "CADDRESS" ,length = 20)
	private String caddress;
	@NonNull
	@Column(name = "BILLAMOUNT")
	private Float billAmount;
	

}
