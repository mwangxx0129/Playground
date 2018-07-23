# pseudo code for Reading 

# Self Definition Rule for Xinxin
# CAS: common assesssment 
# LOC: loc, local review 
# res: result for current scope

updateStatusFromCAS(discharge):
    ## [notNullObj, ...]
    cas_list = cas_list(tag_req)
    ## {"bpci": notNullObj, ...}
    cas_map = cas_list_to_map(car_list)
    
    ## step 1: CAS is empty --------------------------------------#
    if (cas_map.size() == 0):
        loc_list = vbcReview(1, 2)
        loc_list.map(e, () => {res.add(buildReview(e, null)} ))
        return res

    # step 2: local bpci isNotNull---------------------------------#
    ## {"bpci": notNullObj, ...}
    loc_map = local_map(facility_id, discharge_id) 
    if (cas_map.size() > 0 && loc_map.size() > 0):
        copy_cas_list = deep_copy(cas_list);
        copy_cas_list.map(cas, () => {
            String bpci = cas.bpci()
            loc_review = update_local_db_event(loc_map.get(bpci), cas)
            res.add(build(buildReview(loc_review, cas)))
            cas_list.remove(cas);
        })
    
    if (cas_list.size() == 0):


    # Step 3: local bpci isNull ()
    ## [{bpci = null}, ...]
    loc_not_merged_list = bpci__null(facility_id, discharge_id)

    ## Case 1: not_merged is empty
    if (|loc_not_merged_list| == 0 && |cas_list| > 0):
        loc_review = update_local_db_event(new_loc_review, cas)
        res.add(buildReview(loc_review, cas))

    ## Case 2: |not_merged| > 0
    elif (|loc_not_merged_list| > 0 && True):
        ### Case 1: cas 1 - 1 loc
        if (loc_not_merged_list.size() == 1 && cas_list.size() == 1):
            loc_review = update_local_db_event(loc_not_merged_list(0), cas.get(0))
            res.add(buildReview(loc_review, cas))
        ### Case 2: cas >= loc > 0
        elif (|cas| >= |loc| > 0):
            for (i = 0; i < |cas|; ++ i):
                loc_review = update_local_db_event(loc_not_merged_list(count), cas.get(i))
                loc_review = remove(count ++);
                res.add(build(buildReview(loc_review, cas)))

        ### Case 3: loc > cas >= 0
        elif (|loc| > |cas| >= 0):
            loc_not_merged_list.map(loc, () => {
                res.add(buildReview(loc_review, cas))
            })
        
        else:
            # no thing
    
    else:
        # nothing


@throws Exception
cas_list(tag_req):

    tag_req = tag_API.episode(1,2,3)

    patient_id = null

    if (tag_req == null || (patient_id = tagReq.patient()) == null)
        "No Records from tagAPI for discharge id - taggingAPIService.getEpisodeIdByTriKey"

    cas_list = cas_API.history("patient_id")
    
    if (cas_list == null || cas_list.size() == 0)
        "No Records - casAPIService.getInterqualAssessmentHistory"
    
    return cas_list


cas_list_to_map(list):
    cas_map = {}
    cas_list.map(e, () => cas_map.put(e.bpci, e))
    return cas_map