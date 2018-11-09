package com.example.UpstreamService.Domain.Skills;

import com.example.UpstreamService.Domain.Skills.Skill;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chicklet {
    Skill skill;
}
