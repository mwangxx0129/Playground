@Transaction
def updateStatusFromCAS(discharge):
    res = []
    cas_list = []
    patient_id = null
    
    # Get patient id by discharge
    tag_req = tag_API.episode(facility_id, mrn, episode_id)
    if (tag_req == null || (patient_id = tagReq.patient()) == null):
        logger("No Records from tagAPI based on discharge id - taggingAPIService.getEpisodeIdByTriKey")
        return []
    
    # Get CAS by patient_id
    cas_list = cas_API.history("patient_id")
    if (|cas_list| == 0):
        handle_cas_list_empty(facility_id, discharge_id, res)
    else:    
        handle_local_merged_with_cas(facility_id, discharge_id, cas_list, res)
        handle_local_not_merged_with_cas(facility_id, discharge_id, cas_list, res)
    return res


def handle_cas_list_empty(facility_id, discharge_id, res):
    logger("No Records - casAPIService.getInterqualAssessmentHistory")
    loc_list = vbcReview(facility_id, discharge_id)
    loc_list.map(loc, () => {res.add(buildReview(loc, null))} )

def handle_local_merged_with_cas(facility_id, discharge_id, cas_list, res):
    loc_map = local_map(facility_id, discharge_id) 
    if (0 < |cas_list| && 0 < |loc_map|):
        copy_cas_list = deep_copy(cas_list)
        copy_cas_list.map(cas, () => {
            String bpci = cas.bpci()
            loc_review = update_local_db_event(loc_map.get(bpci), cas)
            res.add(build(buildReview(loc_review, cas)))
            cas_list.remove(cas)
        })

def handle_local_not_merged_with_cas(facility_id, discharge_id, cas_list, res):
    ## [{bpci = null}, ...]
    loc_not_merged_list = bpci_null(facility_id, discharge_id)

    ## 1: |not_merged| == 0
    if (0 == |loc_not_merged_list| && 0 < |cas_list|):
        loc_review = update_local_db_event(new_loc_review, cas)
        res.add(buildReview(loc_review, cas))

    ## 2: 0 < |loc_not_merged_list|
    elif (0 < |loc_not_merged_list| && True):
        ### Case 1: cas 1 - 1 loc
        if (|loc_not_merged_list| == 1 && |cas_list| == 1):
            loc_review = update_local_db_event(loc_not_merged_list(0), cas.get(0))
            res.add(buildReview(loc_review, cas))
        ### Case 2: 0 < |loc| <= |cas|
        elif (0 < |loc| <= |cas|):
            for (i = 0; i < |cas|; ++ i):
                loc_review = update_local_db_event(loc_not_merged_list(count), cas.get(i))
                loc_review = loc_not_merged_list.remove(count ++) # remove? NOT understanding
                res.add(build(buildReview(loc_review, cas)))
        ### Case 3: 0 <= |cas| < |loc|  ? Need discussion this handler
        elif (0 <= |cas| < |loc|):
            loc_not_merged_list.map(loc, () => {
                # handle cas == 0 again, since previous possibly remove cas
                res.add(buildReview(loc_review, null))
            })

# Topic: pseudo code for Reading
# Description:
    # Rule for Xinxin self
    # cas: common assesssment
    # loc: loc, local review
    # res: hold the result set
# Change:
    # cas_list.map(cas, () => cas_map.put(cas.bpci, cas)) # Convert list to map
    # remove duplicate code
# Questions: 
    # How to merge
    # Use use case to clarify requirement and all cases